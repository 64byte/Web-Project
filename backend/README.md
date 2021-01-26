# spring-web-porject

spring-web-porject

dependencies
- spring-boot-web (mvc)
- spring-boot-security
- spring-boot-validation
- spring-boot-jpa
- lombok
- postgresql
- jjwt

app
- app-common
    도메인 계층의 패키지 (entity, repository)

- app-external-api
    외부 api 패키지 (controller, service)

- app-internal-api
    내부 api 패키지 (backoffice controller, service)

- app-batch
    배치 서비스 패키지

domain
- user
- address
- category
- product
- product_sku (product)
- color
- cart
- cartItem (cart)
- order
- authentication

코드 작성 관련
- 도메인 중심 디렉토리 구성
- controller <-> service간 데이터 전송은 dto 클래스를 이용
   controller -> service는 request dto, service -> controller는 response dto
- validation은 service method에서 하도록 함.
    ex) SomeResponse somService(@Valid SomeRequest someReq)
    controller method에서 validation을 할 경우에, controller에서 사용하는 service method가 다른 service에서도 호출할 수 있다면 validation을 중복으로 해야함.
    

