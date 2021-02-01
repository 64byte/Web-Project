# spring-web-project

----



아래의 의존성을 바탕으로 작성한 Spring boot 쇼핑몰 Rest API 서버



### Dependencies

- spring-boot-web (mvc)
- spring-boot-security
- spring-boot-validation
- spring-boot-jpa
- lombok
- postgresql
- jjwt



### App

- app-common
  도메인 계층의 패키지 (common, entity, repository)
  - [common](https://github.com/64byte/Web-Project/tree/main/backend/app-common/src/main/java/com/story/backend/common/)
  - [user](https://github.com/64byte/Web-Project/tree/main/backend/app-common/src/main/java/com/story/backend/user/)
  - [address](https://github.com/64byte/Web-Project/tree/main/backend/app-common/src/main/java/com/story/backend/address/)
  - [category](https://github.com/64byte/Web-Project/tree/main/backend/app-common/src/main/java/com/story/backend/category/)
  - [product](https://github.com/64byte/Web-Project/tree/main/backend/app-common/src/main/java/com/story/backend/product/)
  - [color](https://github.com/64byte/Web-Project/tree/main/backend/app-common/src/main/java/com/story/backend/color/)
  - [cart](https://github.com/64byte/Web-Project/tree/main/backend/app-common/src/main/java/com/story/backend/cart/)
  - [order](https://github.com/64byte/Web-Project/tree/main/backend/app-common/src/main/java/com/story/backend/order/)
  - [authentication](https://github.com/64byte/Web-Project/tree/main/backend/app-common/src/main/java/com/story/backend/authentication/)

- app-external-api
  외부 api 패키지 (common, controller, service)
  - [common](https://github.com/64byte/Web-Project/tree/main/backend/app-external-api/src/main/java/com/story/backend/common/)
  - [user](https://github.com/64byte/Web-Project/tree/main/backend/app-external-api/src/main/java/com/story/backend/user/)
  - [address](https://github.com/64byte/Web-Project/tree/main/backend/app-external-api/src/main/java/com/story/backend/address/)
  - [category](https://github.com/64byte/Web-Project/tree/main/backend/app-external-api/src/main/java/com/story/backend/category/)
  - [product](https://github.com/64byte/Web-Project/tree/main/backend/app-external-api/src/main/java/com/story/backend/product/)
  - [color](https://github.com/64byte/Web-Project/tree/main/backend/app-external-api/src/main/java/com/story/backend/color/)
  - [cart](https://github.com/64byte/Web-Project/tree/main/backend/app-external-api/src/main/java/com/story/backend/cart/)
  - [order](https://github.com/64byte/Web-Project/tree/main/backend/app-external-api/src/main/java/com/story/backend/order/)
  - [authentication](https://github.com/64byte/Web-Project/tree/main/backend/app-external-api/src/main/java/com/story/backend/authentication/)
  
- app-internal-api
  내부 api 패키지 (common, backoffice controller, service)
  - [common](https://github.com/64byte/Web-Project/tree/main/backend/app-inetnal-api/src/main/java/com/story/backend/common/)
  - [user](https://github.com/64byte/Web-Project/tree/main/backend/app-inetnal-api/src/main/java/com/story/backend/user/)
  - [address](https://github.com/64byte/Web-Project/tree/main/backend/app-inetnal-api/src/main/java/com/story/backend/address/)
  - [category](https://github.com/64byte/Web-Project/tree/main/backend/app-inetnal-api/src/main/java/com/story/backend/category/)
  - [product](https://github.com/64byte/Web-Project/tree/main/backend/app-inetnal-api/src/main/java/com/story/backend/product/)
  - [color](https://github.com/64byte/Web-Project/tree/main/backend/app-inetnal-api/src/main/java/com/story/backend/color/)
  - [cart](https://github.com/64byte/Web-Project/tree/main/backend/app-inetnal-api/src/main/java/com/story/backend/cart/)
  - [order](https://github.com/64byte/Web-Project/tree/main/backend/app-inetnal-api/src/main/java/com/story/backend/order/)
  - [authentication](https://github.com/64byte/Web-Project/tree/main/backend/app-inetnal-api/src/main/java/com/story/backend/authentication/)
  

- app-batch
  배치 서비스 패키지

  
### Domain

- user 
- address
- category
- product
- product_sku (in product domain)
- color
- cart
- cart_item (in cart domain)
- order
- authentication

## Database
- [SCHEME](https://github.com/64byte/Web-Project/tree/main/backend\app-common\src\main\resources\db\migration)
- 각 테이블은 phantom id (auto increment, 이하 id)와 UUID를 가진다.
  - id는 내부 로직에서 사용하는 PK, UUID는 외부에서 사용하는 PK이다. (N:M 병합 테이블의 경우에는 주로 다른 컨트롤러 혹은 서비스에 의해 접근하므로 id만 가진다)
- 테이블 내용
  - user (가입한 사용자 관련)
  - address (비회원 주문 address, user가 저장하고 있는 address)
  - category (페이지 카테고리, New arrival, mens, womens, etc..)
  - product (제품)
  - product_sku (제품 stock keeping unit, 여기선 주로 사이즈)
  - color (제품 색깔)
  - cart
    - 비회원, 사용자가 아이템을 담을 때 부여받는 고유 ID
  - cart_item
    - cart와 연결되어 cart 안에 담겨져 있는 아이템
  - order
    - 제품 주문 내용
- ~~index 작성 중~~  

### Branch 전략

~~git branch 전략을 따르려고 했으나. main branch를 develop branch로 간주하여 개발하였습니다.~~

 main

- feature/fe-00 (frontend branches, ~~개발 중~~)
- feature/be-00 (backend branches)

### ~~Test~~

- ~~작성 중~~

### 코드 작성 관련

- 도메인 중심 디렉토리 구성

  > domain을 공통 모듈로 두고(entity, repository) 그 외에 여러 모듈(실행되는 모듈, controller, dto, service)로 나눠서 정리함   
  > 외부에서 호출하는 api 서비스와 내부에서(예를 들면 백오피스) 호출하는 api 서비스가 다르다고 판단함. 단점으로는 각 서비스에서 중복 코드가 발생함.

- controller <-> service간 데이터 전송은 dto 클래스를 이용

  > controller -> service는 request dto, service -> controller는 response dto

- validation은 service method에서 하도록 함.

  > ex) SomeResponse somService(@Valid SomeRequest someReq)
  > controller method에서 validation을 할 경우에, controller에서 사용하는 service method가 다른 service에서도 호출할 수 있다면 validation을 중복으로 해야함.

- API의 Response Type은 2가지로 통일

  - CommonResponse (Http code, internal code, result)
    - 정상적인 응답일 경우 반환되는 Response
  - ErrorResponse (Http code, internal code, message)
    - 예외가 발생된 경우 반환되는 Response

- Controller 예외는 한 곳에서 처리한다. (해당 아이디어는 [여기](https://github.com/cheese10yun/spring-guide/blob/master/docs/exception-guide.md) 를 참고했음)
  - app-external-api
    - [GlobalExceptionHandler](https://github.com/64byte/Web-Project/blob/main/backend/app-external-api/src/main/java/com/story/backend/common/handler/GlobalExceptionHandler.java)
  
