package com.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.alibaba.fastjson.JSON;

/**
 * 实体类工具
 * 
 * @author patrick 2015年8月31日
 */
public class EntityUtil {

	/**
	 * 将对象转成map
	 * 
	 * @param obj
	 * @return
	 */
	public static HashMap<String, Object> toMap(Object obj) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		if (obj != null) {
			List<Field> filedList = getFiledList(obj.getClass());

			String filedName = null;
			Class<?> type = null;
			for (Field field : filedList) {
				try {
					filedName = field.getName();
					type = field.getType();
					boolean accessFlag = field.isAccessible();
					field.setAccessible(true);
					Object value = field.get(obj);
					if (type.equals(Date.class)) {
						if (value == null) {
							map.put(filedName, "1970-01-01 00:00:00");
						} else {
							map.put(filedName, TimeUtil.dateToStr((Date) value, TimeUtil.YYYY_MM_DD_HH_MM_SS));
						}
					} else {
						// 只输出属性值不为空
						if (value != null) {
							value = JSON.toJSON(value);
							map.put(filedName, value);
						}
					}
					field.setAccessible(accessFlag);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return map;
	}

	/**
	 * 获取对象的属性
	 * 
	 * @param clazz
	 * @return
	 */
	private static List<Field> getFiledList(Class<? extends Object> clazz) {

		List<Field> filedList = new ArrayList<Field>();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			// 只筛选出私有的属性
			if (Modifier.toString(field.getModifiers()).contains("private")) {
				filedList.add(field);
			}
		}

		if (clazz.getSuperclass() != null) {
			filedList.addAll(getFiledList(clazz.getSuperclass()));
		}

		return filedList;
	}

	public String toString(Object obj) {
		Map<String, Object> map = toMap(obj);

		StringBuffer sf = new StringBuffer();

		sf.append(this.getClass().getSimpleName() + " = ").append(printMap(map));

		return sf.toString();
	}

	/**
	 * 输出支付回调的参数map
	 * 
	 * @param map
	 * @return
	 */
	public static String printMap(Map<String, ?> map) {
		StringBuffer sf = new StringBuffer();

		sf.append("[ ");

		if (map != null) {
			for (Entry<String, ?> entry : map.entrySet()) {
				sf.append("  ").append(entry.getKey()).append(" = ").append(entry.getValue()).append(", ");
			}
		}

		sf.append("]");

		return sf.toString();
	}

	/**
	 * 输出支付回调的参数数组，两个数组的长度必须相等
	 * 
	 * @param map
	 * @return
	 */
	public static String printArray(String[] notifyvo, String[] resArr) {
		StringBuffer sf = new StringBuffer();

		sf.append("[ ");

		if (notifyvo != null && resArr != null && notifyvo.length == resArr.length) {
			for (int i = 0, l = notifyvo.length; i < l; i++) {
				sf.append("  ").append(notifyvo[i]).append(" = ").append(resArr[i]).append(", ");
			}
		}

		sf.append("]");

		return sf.toString();
	}

}
