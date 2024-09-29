# Practical Work 

## Topic
Dependency Injection and Inversion of Control via Spring Context.

## Objective
The goal of this practical task is to become familiar with basic Internet concepts through working with sockets and to practice server-client interaction. Additionally, it involves applying the principles of Inversion of Control (IoC) and Dependency Injection (DI) using the Spring Framework.

## Overview
In this task, you will work with Spring Context to manage product and cart operations using Dependency Injection. The focus is on building and testing a system where a cart can store products, and both cart and product repositories are managed using Spring beans.

### Requirements:
1. **Product Class**: Create a `Product` class with the following fields:
   - `id`
   - `name`
   - `price`
   
   Products will be stored in a `ProductRepository` bean, represented as a `List<Product>`. Upon application startup, 5 products should be added to this repository.

2. **ProductRepository**: This singleton repository will allow retrieval of:
   - The entire product list
   - A single product by its `id`

3. **Cart Class**: Implement a `Cart` bean that allows:
   - Adding products by their `id`
   - Removing products by their `id`
   
   Each request for a cart should create a new instance, ensuring that the cart is prototype-scoped.

4. **Spring Annotations**:
   - `ProductRepository` should be a singleton.
   - `Cart` should have `@Scope("prototype")`.
   - Products should be added to `ProductRepository` after the bean is created using the `@PostConstruct` annotation.
   - The cart should be represented as a `Map<Product, Integer>`, where the key is the product, and the value is the quantity in the cart.
   
5. **CartServiceImpl**: Use the `@Autowired` annotation in the setter method `setProductRepository()` to inject the `ProductRepository` bean.

6. **Testing**: Write unit tests to demonstrate the functionality of both the product repository and cart. The tests should verify that:
   - Products can be added and removed from the cart.
   - The cart is properly scoped, meaning a new cart is created for each request.

## Tasks
### Task 1: ProductRepository Implementation
- Implement the `ProductRepository` as a singleton bean.
- Use `@PostConstruct` to populate it with 5 products upon application startup.

### Task 2: Cart Implementation
- Create a `Cart` class that stores products in a `Map<Product, Integer>`.
- Ensure that the `Cart` bean has a `@Scope("prototype")` annotation, so a new cart is created for every request.

### Task 3: CartServiceImpl
- Implement `CartServiceImpl` with methods to add and remove products by `id` from the cart.
- Use the `@Autowired` annotation for injecting the `ProductRepository` using a setter method.

### Task 4: Testing
- Write unit tests to demonstrate the functionality of adding/removing products from the cart.
- Verify that each request generates a new cart instance and that the product repository functions as expected.

## Conclusion
By completing this practical work, you will become familiar with Dependency Injection and Inversion of Control principles in Spring, alongside understanding the role of scope in bean management. Additionally, this task will reinforce your understanding of testing Spring applications.

## Usage
1. Clone this repository to your local machine.
2. Run the application using a Spring-compatible environment.
3. Use the tests to verify functionality.

## Contribution Guidelines
Contributions to the practical work are welcome. Follow these steps to contribute:
1. Fork the repository.
2. Create a new branch for your feature or bug fix: `git checkout -b feature/new-feature`.
3. Make changes and commit them: `git commit -m "Add new feature"`.
4. Push changes to your fork: `git push origin feature/new-feature`.
5. Open a pull request.

## License
This project is licensed under the [MIT License](LICENSE).
