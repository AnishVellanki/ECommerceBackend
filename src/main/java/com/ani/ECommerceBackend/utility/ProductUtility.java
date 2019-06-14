package com.ani.ECommerceBackend.utility;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.ani.ECommerceBackend.daoImpl.ProductDaoImpl;
import com.ani.ECommerceBackend.model.Product;

public class ProductUtility {

	@Autowired
	ProductDaoImpl productDaoImpl;
	public void fileUpload(@ModelAttribute("addPro") Product product)
	{
			MultipartFile imageFile=product.getProductImage();
			System.out.println("~~~~~~~~~~~~~~~~~imagefile"+imageFile);
			BufferedOutputStream bos=null;
			try {
				
				
					byte byteArray[];
					byteArray = imageFile.getBytes();
					FileOutputStream fos=new FileOutputStream("D:\\ECommerce-workspace\\ECommerceFrontend\\src\\main\\webapp\\resources\\product-images\\"+product.getProductId()+".jpg");
					bos=new BufferedOutputStream(fos);
					bos.write(byteArray);
					
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
				
			 catch (IOException e) {
				e.printStackTrace();
			}
		finally
		{
			
			try {
				bos.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
						}
}