package co.yedam.app;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import polymorphism.coupling.TV;

@RunWith(SpringRunner.class)
@ContextConfiguration({"/applicationContext.xml"})

public class TvUserClient {
	
	//@Autowired TV tv; 
	//@Autowired @Qualifier("ltv") TV tv;
	@Resource(name="stv") TV tv;
	
	@Test	
	public void tvTest() {
			tv.powerOn();
			tv.volumeUp();
		}
}
