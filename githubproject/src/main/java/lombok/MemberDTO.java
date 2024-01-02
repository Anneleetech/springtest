package lombok;

import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class MemberDTO {
	String memberid;
	final String pw="test"; //1번 설정값(생성자) 상수. 수정불가 
}
