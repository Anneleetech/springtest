package db_jasypt;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@Configuration //xml 대신 자바 설정파일
@EnableEncryptableProperties //암호화/복호화/ 메소드 클래스 위
public class JasyptConfig {
	@Autowired
	Environment environment;
	@Bean("jasyptEncryptor")
	public StringEncryptor stringEncryptor() {
		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(environment.getProperty("jasypt.encryptor.password"));
       
         //applictioan.properties + JasyptConfig.java ->github push 
        
        //config.setPassword("1234");
       // config.setAlgorithm("PBEWithMD5AndDES"); // 알고리즘
      //  config.setKeyObtentionIterations("1000");
        //자바클래스 실행 -환경변수 읽어서 사용
        config.setPoolSize("1");
       // config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
       // config.setStringOutputType("base64");
        encryptor.setConfig(config);
       
        return encryptor;
        
	}
}
