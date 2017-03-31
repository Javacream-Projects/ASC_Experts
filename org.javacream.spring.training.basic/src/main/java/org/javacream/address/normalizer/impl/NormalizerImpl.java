package org.javacream.address.normalizer.impl;

import org.javacream.address.normalizer.api.Normalizer;
import org.springframework.stereotype.Service;

@Service
public class NormalizerImpl implements Normalizer {

	@Override
	public String normalize(String input) {
		String result = input.replaceAll(" ", "");
		result = result.replaceAll("-", "");
		result = result.replaceAll("_", "");
		result = result.toUpperCase();
		return result;
	}

}
