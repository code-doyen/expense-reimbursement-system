import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

import com.revature.aspect.TracingAspect;

public class ExceptionAspect {
	public static final Logger logger = Logger.getLogger(ExceptionAspect.class);
	
	@AfterThrowing(pointout = "* *(..)), )", thwrowing ="e")
	public void exceptionHandling(JoinPoint joinPoint, Exception e){
		logger.error("Exceptpoin thrown in : " + joinPoint.getStaticPart().toString(), e);
	}
}
