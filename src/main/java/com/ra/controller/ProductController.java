package com.ra.controller;

import com.ra.model.Categories;
import com.ra.model.Images;
import com.ra.model.Product;
import com.ra.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.ManyToOne;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/productController")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoriesService categoriesService;
    @Autowired
    private UploadFileService uploadFileService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private BillDetailService billDetailService;
    private static final int SIZE = 3;
    private static String productNameDefault = "";
    private static String directionDefault = "ASC";
    private static String sortByDefault = "productId";
    private static int pageDefault = 1;

    @GetMapping("/findProduct")
    public ModelAndView displayProduct(Optional<String> productName, Optional<Integer> page,
                                       Optional<String> direction, Optional<String> sortBy) {
        ModelAndView mav = new ModelAndView("products");
        productNameDefault = productName.orElse(productNameDefault);
        directionDefault = direction.orElse(directionDefault);
        sortByDefault = sortBy.orElse(sortByDefault);
        pageDefault = page.orElse(pageDefault);
        //Lấy dữ liệu hiển thị
        List<Product> listProducts = productService.displayData(productNameDefault, pageDefault - 1, SIZE,
                directionDefault, sortByDefault);
        //Lấy ra danh sách các trang theo kết quả tìm kiếm
        List<Integer> listPages = productService.getListPage(productNameDefault, SIZE);
        mav.addObject("listProducts", listProducts);
        mav.addObject("listPages", listPages);
        mav.addObject("productName", productNameDefault);
        mav.addObject("sortBy", sortByDefault);
        mav.addObject("direction", directionDefault);
        return mav;
    }

    @GetMapping(value = "/initCreate")
    public String initCreateProduct(ModelMap modelMap) {
        Product product = new Product();
        //Lấy thông tin tất cả các danh mục
        List<Categories> listCategories = categoriesService.getAllCatalog();
        modelMap.addAttribute("product", product);
        modelMap.addAttribute("listCategories", listCategories);
        return "newProduct";
    }

    @GetMapping(value = "/initUpdate")
    public String initProductUpdate(ModelMap modelMap, String productId) {
        Product productEdit = productService.findById(productId);
        List<Categories> listCategories = categoriesService.getAllCatalog();
        List<Images> listImage = imageService.getImageByProductId(productId);
        modelMap.addAttribute("productEdit", productEdit);
        modelMap.addAttribute("listCategories", listCategories);
        modelMap.addAttribute("listImage", listImage);
        return "updateProduct";
    }

    @PostMapping(value = "/create")
    public String createProduct(Product product, MultipartFile productImage, MultipartFile[] otherImages) {
        String urlImage = uploadFileService.uploadFile(productImage);
        product.setImage(urlImage);
        Product proNew = productService.save(product);
        if (proNew != null) {
            // Thực hiện thêm mới các ảnh phụ của sản phẩm
            Arrays.asList(otherImages).forEach(image -> {
                String imageLink = uploadFileService.uploadFile(image);
                Images images = new Images();
                images.setProduct(proNew);
                images.setImageUrl(imageLink);
                // Thêm mới vào model Images
                boolean result = imageService.save(images);
            });
            return "redirect:findProduct";
        } else {
            return "error";
        }
    }

    @PostMapping(value = "/update")
    public String updateProduct(Product product, MultipartFile productImage, MultipartFile[] otherImages) {
        Product oldProduct = productService.findById(product.getProductId());
        if (productImage != null && !productImage.getOriginalFilename().isEmpty()) {
            String urlImage = uploadFileService.uploadFile(productImage);
            product.setImage(urlImage);
        } else {
            product.setImage(oldProduct.getImage());
        }
        Product updateProduct = productService.update(product);
        if (otherImages != null) {
            Arrays.asList(otherImages).forEach(image -> {
                String imageLink = uploadFileService.uploadFile(image);
                Images images = new Images();
                images.setProduct(product);
                images.setImageUrl(imageLink);
                // Thêm mới vào model Images
                boolean result = imageService.save(images);
            });
        } else {
            product.setListImages(oldProduct.getListImages());
        }
        if (updateProduct != null) {
            return "redirect:findProduct";
        } else {
            return "error";
        }
    }

    @GetMapping("/delete")
    public String deleteProduct(String productId) {
        if (billDetailService.billDetailHaveProductId(productId)) {
            return "error";
        }
        boolean result = productService.delete(productId);
        if (result) {
            return "redirect:findProduct";
        } else {
            return "error";
        }
    }
}
