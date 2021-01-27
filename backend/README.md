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
  - user
    - [entity](https://github.com/64byte/Web-Project/tree/main/backend/app-common/src/main/java/com/story/backend/user/entity)
    - [repository](https://github.com/64byte/Web-Project/tree/main/backend/app-common/src/main/java/com/story/backend/user/repository)
  - address
    - [entity](https://github.com/64byte/Web-Project/tree/main/backend/app-common/src/main/java/com/story/backend/address/entity)
    - [repsository](https://github.com/64byte/Web-Project/tree/main/backend/app-common/src/main/java/com/story/backend/adderss/repository)
  - 
- app-external-api
  외부 api 패키지 (common, controller, service)
- app-internal-api
  내부 api 패키지 (common, backoffice controller, service)
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

