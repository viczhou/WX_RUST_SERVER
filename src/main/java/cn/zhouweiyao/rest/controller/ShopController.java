package cn.zhouweiyao.rest.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.zhouweiyao.rest.pojo.ShopInfo;
import cn.zhouweiyao.rest.service.IShopInfoService;
import cn.zhouweiyao.rest.utils.JsonUtils;
import cn.zhouweiyao.rest.vo.Msg;
import cn.zhouweiyao.rest.vo.ShopInfoRegisterVo;
import cn.zhouweiyao.rest.vo.ShopInfoVo;
import cn.zhouweiyao.rest.vo.UploadImageVo;

/**
 * 商店
 * 
 * @author Mr.Liang
 *
 */
@Controller
@RequestMapping("/shop")
public class ShopController {
	/** 图片前缀 **/
	private static final String IMAG_PREFIX = "shop_img";
	/** 图片临时目录相对地址 **/
	private static final String TMP_FILE = "/static/tmp";
	/** 商家图片地址 **/
	private static final String SHOP_IMG_FILE = "/static/shopImg";
	/** 默认图片 **/
	private static final String DEFAULT_IMG = "shop_img";
	@Autowired
	private IShopInfoService shopInfoService;

	/**
	 * 'user_id : xxxxx, 'shop_name':'xxxxx', 'shop_phone':'xxxxxx',
	 * 'shop_license':'00000000000000', 'resp_name' : 'sssss' //负责人姓名
	 * 'resp_phone' : 'xxxxxxxxx', 'shop_address' : 'xxxxxxxxx', 'longitude' :
	 * '111111', //经度 'latitude' : '11111' , //纬度
	 * 
	 * 
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public ShopInfoRegisterVo register(Integer user_id, String shop_name, String shop_license, String shop_phone, String resp_name,
			String resp_phone, String shop_address, String longitude, String latitude, String shop_img,
			HttpServletRequest request) {

		if (user_id == null || StringUtils.isBlank(shop_name) || StringUtils.isBlank(shop_license)
				|| StringUtils.isBlank(resp_name) || StringUtils.isBlank(resp_phone)
				|| StringUtils.isBlank(shop_address) || StringUtils.isBlank(longitude)
				|| StringUtils.isBlank(latitude) || StringUtils.isBlank(shop_phone)) {
			return new ShopInfoRegisterVo(1, null);
		}

		ShopInfo shopInfo = shopInfoService.saveShopInfo(user_id, shop_name, shop_license, shop_phone, resp_name, resp_phone,
				shop_address, longitude, latitude, shop_img);

		/** 更新图片 **/
		if (StringUtils.isNotBlank(shopInfo.getShopImg())) {
			String imageSrc = null;
			try {
				imageSrc = copyImage(shopInfo.getShopImg(), shopInfo.getId(), request);
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (StringUtils.isNotBlank(imageSrc)) {
				shopInfo.setShopImg(imageSrc);
				shopInfoService.updateShopInfo(shopInfo);
			}

		}

		return new ShopInfoRegisterVo(0, shopInfo.getId());
	}

	/**
	 * 更改信息 'shop_id':xxxxx , 'shop_name':'xxxxx', 'shop_phone':'xxxxxx',
	 * 'resp_name' : 'sssss' //负责人姓名 'resp_phone' : 'xxxxxxxxx', 'shop_address'
	 * : 'xxxxxxxxx', 'longitude' : '111111', //经度 'latitude' : '11111' , //纬度
	 * 'shop_img' : xxxxxxx
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/change", method = RequestMethod.POST)
	@ResponseBody
	public Msg changeShopInfo(Integer shop_id, String shop_name, String shop_license, String shop_phone, String resp_name,
			String resp_phone, String shop_address, String longitude, String latitude, String shop_img,
			HttpServletRequest request) throws IOException {
		if (StringUtils.isBlank(shop_name) || StringUtils.isBlank(shop_license)
				|| StringUtils.isBlank(resp_name) || StringUtils.isBlank(resp_phone)
				|| StringUtils.isBlank(shop_address) || StringUtils.isBlank(longitude)
				|| StringUtils.isBlank(latitude) || StringUtils.isBlank(shop_phone)) {
			return new Msg(1);
		}
		ShopInfo shopInfo = this.shopInfoService.getShopInfoById(shop_id);
		if (shopInfo == null) {return new Msg(1);}
		String imgSrc = copyImage(shop_img, shop_id, request);
		shopInfo.setShopName(shop_name);
		shopInfo.setShopLicence(shop_license);
		shopInfo.setShopPhone(shop_phone);
		shopInfo.setRespName(resp_name);
		shopInfo.setRespPhone(resp_phone);
		shopInfo.setShopAddress(shop_address);
		shopInfo.setShopLongitude(longitude);
		shopInfo.setShopLatitude(latitude);
		shopInfo.setShopImg(imgSrc);
		this.shopInfoService.updateShopInfo(shopInfo);
		return new Msg(0);
	}

	/**
	 * 营业or打样
	 * 
	 * @param shop_id
	 * @param status
	 * @return
	 */
	@RequestMapping(value = "/changeStatus", method = RequestMethod.POST)
	@ResponseBody
	public Msg changeShopStatus(Integer shop_id, Byte status) {
		return shopInfoService.updateShopStatus(shop_id, status);
	}

	/**
	 * 根据id获取店铺信息
	 * 
	 * @param shop_id
	 * @return
	 */
	@RequestMapping(value = "/getShopInfo", method = RequestMethod.POST)
	@ResponseBody
	public ShopInfoVo getShopInfo(Integer shop_id) {
		ShopInfo shopInfo = shopInfoService.getShopInfoById(shop_id);
		if (shopInfo == null) {
			return new ShopInfoVo(1);
		}
		return new ShopInfoVo(0, shopInfo.getShopName(), shopInfo.getShopPhone(), shopInfo.getShopAddress(),
				shopInfo.getShopLatitude(), shopInfo.getShopLongitude(), shopInfo.getShopImg(),
				shopInfo.getShopStatus());
	}

	/**
	 * 上传图片
	 * 
	 * @param file_name
	 * @param filePath
	 * @param flag
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/uploadImag", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String uploadFile(MultipartFile file_name, String filePath,
			@RequestParam(value = "flag", defaultValue = "0") Integer flag, HttpServletRequest request) {
		String tmpPath = request.getSession().getServletContext().getRealPath(TMP_FILE);
		/** 上传为空 **/
		if (file_name.isEmpty()) {
			return JsonUtils.objectToJson(new UploadImageVo(1, null));
		}

		String imageName = createImageName(file_name.getOriginalFilename());

		try {
			transToFile(file_name.getInputStream(), tmpPath, imageName);
			return JsonUtils.objectToJson(new UploadImageVo(0, imageName));
		} catch (IOException e) {
			e.printStackTrace();
			return JsonUtils.objectToJson(new UploadImageVo(1, null));
		}
	}

	/**
	 * 生成图片名
	 * 
	 * @param image
	 * @return
	 */
	private static String createImageName(String image) {

		if (StringUtils.isBlank(image)) {

			return "shop_img.jpg";

		}

		String subFix = image.substring(image.lastIndexOf("."));

		if (StringUtils.isBlank(subFix)) {

			return "shop_img.jpg";

		}

		String path = String.valueOf(System.currentTimeMillis());
		Random ran = new Random();
		for (int i = 0; i < 3; i++) {
			path += (char) (65 + ran.nextInt(26));
			path += ran.nextInt(10);
			path += (char) (97 + ran.nextInt(26));
		}

		return IMAG_PREFIX + path + subFix;

	}
	public static void main(String[] args) {
		System.out.println(createImageName("test.jpg"));
	}
	/**
	 * 输入流复制到历史目录
	 * 
	 * @param is
	 * @param tmpPath
	 * @param imgName
	 * @throws IOException
	 */
	private void transToFile(InputStream is, String tmpPath, String imgName) throws IOException {

		File file = new File(tmpPath, imgName);
		if (!file.exists())
			return;
		FileOutputStream fos = new FileOutputStream(file);
		byte buff[] = new byte[1024];
		int len = 0;
		while ((len = is.read(buff)) != -1) {
			fos.write(buff, 0, len);
			fos.flush();
		}
		fos.close();
		is.close();
	}

	/**
	 * 复制图片
	 * 
	 * @param imageSrc
	 * @param shop_id
	 * @param request
	 * @throws IOException
	 */
	private static String copyImage(String imageSrc, Integer shop_id, HttpServletRequest request) throws IOException {

		String tmpPath = request.getSession().getServletContext().getRealPath(TMP_FILE);
		if (StringUtils.isBlank(imageSrc))
			return null;
		File tmpFile = new File(tmpPath, imageSrc);
		if (!tmpFile.exists())
			return null;
		String targetParentPath = request.getSession().getServletContext().getRealPath(SHOP_IMG_FILE);
		/** 后缀 **/
		String extName = imageSrc.substring(imageSrc.lastIndexOf("."));
		File parentFile = new File(targetParentPath + File.separator + String.valueOf(shop_id));
		/** 创建目录 **/
		if (!parentFile.exists())
			parentFile.mkdirs();
		File shopImageFile = new File(parentFile, DEFAULT_IMG + extName);

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
		/**删除临时目录图片**/
		tmpFile.delete();
		return SHOP_IMG_FILE + File.separator + String.valueOf(shop_id) + File.separator + shopImageFile.getName();
	}

}
