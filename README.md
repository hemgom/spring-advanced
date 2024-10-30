# SPRING ADVANCED
`심화 주차` 에서 수강한 강의 내용을 `다른 개발자` 가 작성한 코드에 반영해 보며 `추후 프로젝트` 에 활용할 수 있도록 연습을 하는 목적의 프로젝트
<br/><br/><br/>

# 요구사항
필수 기능의 요구사항의 경우 `이전 프로젝트(JPA 를 기반으로한 일정 관리 앱 구현)` 피드백을 반영하며 어느 정도 해소했다고 생각해 `도전 기능` 에 대한 요구사항을 정리 및 반영했다.
## Level.03 - 추가 기능 개선
### 1. Early Return
- [x] : 수행 중 `정상적인 수행 흐름을 벗어난다면` 즉시 예외 또는 예외에 해당하는 로직을 수행해 `불필요한 로직의 수행을 방지` 해 성능을 향상 시킨다.
  - 패키지 `package org.example.expert.domain.auth.service` 의 `AuthService 클래스` 에 있는 `signup()` 의 수행부를 리팩토링해 위 요구사항을 만족시킨다.
<br/>

### 2. 불필요한 if-else 피하기
- [x] : 불필요하게 복잡한 `if-else` 구조는 `코드 가독성을 떨어뜨리고` `유지보수를 어렵게` 만든다.
  - 패키지 `package org.example.expert.client` 의 `WeatherClient 클래스` 에 있는 `getTodayWeather()` 의 수행부를 리팩토링해 위 요구사항을 만족시킨다.
<br/>

### 3. 코드 클린업 - 불필요 주석 제거, 코드 포맷팅, 일관된 네이밍 컨벤션
개인과제의 특성상 해당 요구사항은 제대로 반영하기 어렵다고 판단, 현재 가능한 부분은 시도해보고 나머지 부분은 추후 프로젝트에 활용해 보기로 하였다.
- [x] : 불필요한 주석 제거
  - [x] : 코드가 명확하게 이해될 수 있도록 불필요한 주석은 제거합니다.
    - [x] : 주석의 추상화 수준과 코드의 추상화 수준의 동일한 경우
      - 코드의 추상화 수준을 주석의 추상화 수준과 동일하게끔 수정한 경우
    - [x] : 주석이 코드의 내용을 중복하는 경우 제거
    - [x] : 설명이 불명확하거나 혼란스러운 주석 삭제
    - [x] : 코드의 동작을 설명하기보다는 '왜' 해당 코드를 작성했는지를 설명하는 주석은 남김
- [ ] : 코드 포맷팅
  - [ ] : 일관된 코드 스타일을 유지하기 위해 코드 포맷팅을 적용합니다.
    - [ ] : 각 클래스, 메서드, 변수에 대한 적절한 공백 및 줄바꿈 적용
    - [ ] : 2칸 또는 4칸의 스페이스(탭) 사용, 팀 내 합의된 방식에 따름
    - [ ] : 괄호 `{}`는 다음 줄에 위치시키거나 같은 줄에 위치시키는 규칙을 팀 내에서 정하고 적용
    - [ ] : 한 줄의 최대 길이는 80~120자로 제한
    - [ ] : 메서드 인자와 파라미터 목록 간의 공백 적용
    - [ ] : 코드 정렬 및 정리(예: import 문 정리)
    - [x] : `Hint!` google-java-formatter, ktlint 와 같은 린트도 찾아서 활용해보세요!
      - Naver-coding-convention 을 프로젝트에 적용해보았습니다.
- [ ] : 일관된 네이밍 컨벤션 적용
  - [ ] : 변수명, 메서드명, 클래스명 등 모든 네이밍에 대해 일관된 규칙을 적용합니다.
    - [ ] : 클래스 이름은 대문자로 시작하는 파스칼 케이스(`PascalCase`) 사용
    - [ ] : 메서드 이름 및 변수 이름은 소문자로 시작하는 카멜 케이스(`camelCase`) 사용
    - [ ] : 상수 이름은 모두 대문자로 작성하고 단어 사이에 언더스코어(`_`) 사용 (예: `MAX_LENGTH`)
    - [ ] : 이름이 그 행위를 충분히 설명하고 있는지?
      네이밍은 의미를 명확히 전달하도록 작성 (예: `getUserById`는 `findUserById`로 변경 가능)
    - [ ] : 접두사 또는 접미사를 통한 일관성 유지 (예: DTO는 `UserDTO`, Service는 `UserService` 등)
<br/>

### 4. 중복 코드 제거
단순하게 중복 코드를 제거한다고 `private` 메서드로 추출하는 것을 말하는 것이 아님에 유의하자. 중복된 코드를 수행하기 `적합한 역할을 가진 클래스에 위임하는 방식` 을 사용해 볼 것!
- [x]  중복 코드 식별
    - [x]  프로젝트 내에서 반복적으로 사용되는 코드를 찾아냅니다.
        - [x]  유사한 로직이 여러 곳에서 사용되는지 확인
        - [x]  동일한 기능을 수행하는 코드 블록을 검색
        - [x]  메서드 내의 반복적인 코드나 클래스 간의 중복 코드 파악
- [x]  메서드로 추출
    - [x]  중복된 코드를 유틸리티 메서드로 추출하여 재사용성을 높입니다.
        - [x]  중복 코드의 기능을 분석하고, 재사용 가능한 메서드를 생성
        - [x]  메서드 이름은 기능을 명확히 전달할 수 있도록 작성
        - [x]  메서드는 단일 책임 원칙(SRP)을 준수해야 하며, 한 가지 기능만 수행하도록 구현
<br/><br/>

## Level.04 - 테스트 코드 & AOP
### 1. 테스트 연습(1)
- [ ] : 테스트 패키지 `package org.example.expert.config` 의 `PassEncoderTest 클래스` 에 있는 `matches_메서드가_정상적으로_동작한다()` 테스트가 의도대로 성공할 수 있게 수정한다.
<br/>

### 2. 테스트 연습(2)
- [ ] : 테스트 패키지 `package org.example.expert.domain.manager.service` 의 `ManagerServiceTest 의 클래스` 에 있는 `manager_목록_조회_시_Todo가_없다면_NPE_에러를_던진다()` 테스트가 성공하고 컨텍스트와 일치하도록 테스트 코드와 테스트 코드 메서드 명을 수정한다.
- [ ] : 테스트 패키지 `org.example.expert.domain.comment.service` 의 `CommentServiceTest 의 클래스` 에 있는 `comment_등록_중_할일을_찾지_못해_에러가_발생한다()` 테스트가 성공할 수 있도록 테스트 코드를 수정한다.
- [ ] : 테스트 패키지 `org.example.expert.domain.manager.service` 의 `ManagerServiceTest 클래스` 에 있는 `todo의_user가_null인_경우_예외가_발생한다()` 테스트가 성공할 수 있도록 서비스 로직을 수정한다.
<br/>

### 3. APO
- [ ] : `Admin` 사용자만 접근할 수 있는 특정 API 에는 접근할 때마다 `접근 로그` 를 기록해야 한다.
  - [ ] : 패키지 `org.example.expert.domain.comment.controller` 의 `CommentAdminController` 클래스에 있는 `deleteComment()`
  - [ ] : 패키지 `package org.example.expert.domain.user.controller` 의 `UserAdminController` 클래스에 있는 `changeUserRole()`
  - [ ] : `Spring AOP` 를 활용해 접근 로그를 기록하는 기능을 구현한다.