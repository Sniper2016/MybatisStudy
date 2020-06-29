package cn.gameboys.simplebatis.frame.invoke;

import java.util.Locale;

/**
 * 
 * @Description:
 * @author: www.gameboys.cn
 * @date:2020年6月29日 下午3:19:55
 */
public final class PropertyNamer {

	private PropertyNamer() {
		// Prevent Instantiation of Static Class
	}

	public static String methodToProperty(String name) {
		if (name.startsWith("is")) {
			name = name.substring(2);
		} else if (name.startsWith("get") || name.startsWith("set")) {
			name = name.substring(3);
		}
		if (name.length() == 1 || (name.length() > 1 && !Character.isUpperCase(name.charAt(1)))) {
			name = name.substring(0, 1).toLowerCase(Locale.ENGLISH) + name.substring(1);
		}

		return name;
	}

	public static boolean isProperty(String name) {
		return isGetter(name) || isSetter(name);
	}

	public static boolean isGetter(String name) {
		return (name.startsWith("get") && name.length() > 3) || (name.startsWith("is") && name.length() > 2);
	}

	public static boolean isSetter(String name) {
		return name.startsWith("set") && name.length() > 3;
	}
}
