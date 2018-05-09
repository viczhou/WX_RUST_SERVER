package cn.zhouweiyao.rest.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zhouweiyao.rest.pojo.ShopFood;
import cn.zhouweiyao.rest.service.IShopFoodService;
import cn.zhouweiyao.rest.utils.ApiResult;
import cn.zhouweiyao.rest.vo.AddFoodVo;
import cn.zhouweiyao.rest.vo.Msg;

@Controller
@RequestMapping("/food")
public class FoodController {

	@Autowired
	private IShopFoodService shopFoodService;

	private static final String TMP_FILE = "/static/tmp";
	private static final String FOOD_FILE = "/static/food";

	// 'menu_id':xxxxx ,
	// 'food_img':xxxxx,
	// 'food_name':xxxxx,
	// 'food_price':xxxxxxx
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public AddFoodVo addFood(Integer menu_id, String food_name, String food_img, String food_price,
			HttpServletRequest request) {

		ShopFood shopFood = shopFoodService.saveShopFood(menu_id, food_name, food_img, food_price);

		try {
			String copyImage = copyImage(shopFood.getFoodImg(), shopFood.getId(), request);

			if (StringUtils.isNotBlank(copyImage)) {

				shopFood.setFoodImg(copyImage);
				shopFoodService.updateShopFood(shopFood);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new AddFoodVo(0, shopFood.getId());
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Msg updateFood(Integer menu_id, Integer food_id, String food_name, BigDecimal food_price, String food_img,
			HttpServletRequest request) {

		ShopFood shopFood = this.shopFoodService.getShopFoodById(food_id);
		if (shopFood == null) {
			return new Msg(1);
		}
		shopFood.setFoodName(food_name);
		
		shopFood.setMenuId(menu_id);
		
		shopFood.setFoodPrice(food_price);

		try {
			String copyImage = copyImage(food_img, shopFood.getId(), request);
			shopFood.setFoodImg(copyImage);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.shopFoodService.updateShopFood(shopFood);
		return new Msg(0);

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Msg deleteFood(Integer food_id) {
		this.shopFoodService.deleteShopFoodById(food_id);
		return new Msg(0);
	}

	/**
	 * 复制图片
	 * 
	 * @param imageSrc
	 * @param shop_id
	 * @param request
	 * @throws IOException
	 */
	private static String copyImage(String imageSrc, Integer food_id, HttpServletRequest request) throws IOException {

		String tmpPath = request.getSession().getServletContext().getRealPath(TMP_FILE);
		if (StringUtils.isBlank(imageSrc))
			return null;
		File tmpFile = new File(tmpPath, imageSrc);
		if (!tmpFile.exists())
			return null;
		String targetParentPath = request.getSession().getServletContext().getRealPath(FOOD_FILE);
		/** 后缀 **/
		String extName = imageSrc.substring(imageSrc.lastIndexOf("."));
		String shopImageFile = targetParentPath + File.separator + String.valueOf(food_id) + extName;
		/** 复制 **/
		FileInputStream fis = new FileInputStream(tmpFile);
		FileOutputStream fos = new FileOutputStream(shopImageFile);
		byte[] buff = new byte[1024];
		int len = 0;
		while ((len = fis.read(buff)) != -1) {
			fos.write(buff, 0, len);
			fos.flush();
		}
		fos.close();
		fis.close();
		return targetParentPath + File.separator + shopImageFile;
	}

	@RequestMapping(value = "/getFood", method = RequestMethod.POST)
	@ResponseBody
	public ApiResult getFood(Integer menu_id) {

		ApiResult result = new ApiResult();
		List<ShopFood> food = this.shopFoodService.getShopFoodByMenuId(menu_id);
		result.setData(food);
		return result;
	}

}
