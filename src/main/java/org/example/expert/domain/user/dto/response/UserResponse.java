package org.example.expert.domain.user.dto.response;

import org.example.expert.domain.user.entity.User;

import lombok.Getter;

@Getter
public class UserResponse {

    private final Long id;
    private final String email;

    private UserResponse(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    // 현재 대부분의 응답에 사용되는 DTO 를 생성할 때 '생성자' 를 통해 생성하고 있습니다.
    // 가장 기본적인 방법이나 해당 방법은 생성시 필요한 파라미터가 많을 수록 코드 가독성 및 유지보수성을 떨어뜨릴 수 있다 생각됩니다.
    // 따라서 아래와 같이 DTO 클래스에 내에 DTO 를 생성하는 역할을 갖는 static 메서드를 작성하는 것이 좋아 보입니다.
    // 이렇게 되면 DTO 생성에 필요한 필드가 추가/삭제 될 때 DTO 클래스에 작성된 메서드만을 관리하면 되기 때문입니다.
    // 개인적으로 Builder 를 사용하는 편이지만 작성된 코드에 Builder 를 찾을 수 없어 생성자를 유지한채로 수정해 보았습니다.
    public static UserResponse makeResponse(User user) {
        return new UserResponse(user.getId(), user.getEmail());
    }
}
