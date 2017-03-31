package org.javacream.address.normalizer.test;

import org.javacream.address.normalizer.api.Normalizer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class NormalizerTest {
	
	@Autowired
	private Normalizer normalizer;

	@Test public void testUpperCase(){
		String s = "Hugo";
		Assert.assertEquals("HUGO", normalizer.normalize(s));
	}
	@Test public void testReplaceUnderscores(){
		String s = "Hu_g_o";
		Assert.assertEquals("HUGO", normalizer.normalize(s));
	}
	@Test public void testReplaceHyphens(){
		String s = "Hu-g-o";
		Assert.assertEquals("HUGO", normalizer.normalize(s));
	}
	@Test public void testReplaceHyphensAndUnderscores(){
		String s = "_H-u_g-o_";
		Assert.assertEquals("HUGO", normalizer.normalize(s));
	}

}
