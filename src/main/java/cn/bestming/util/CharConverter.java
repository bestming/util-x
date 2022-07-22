package cn.bestming.util;

/**
 * 单个字符转换接口
 *
 * @author bestming
 * @date 2021-4-23
 */
public interface CharConverter {

	char apply(char ch);

	enum CharCase implements CharConverter {
		NONE(ch -> ch),
		UPPER(Character::toUpperCase),
		LOWER(Character::toLowerCase);

		final CharConverter converter;

		CharCase(CharConverter converter) {
			this.converter = converter;
		}

		public char apply(char ch) {
			return converter.apply(ch);
		}
	}
}
