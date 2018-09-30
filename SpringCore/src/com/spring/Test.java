package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Tight Coupling(coupling):- it means degree of dependency is more between two
 * object or class   class A{               class B{
 * 				    	B b=new B();
 * 						}   				}
 */						
/**
 * Loose coupling(d-coupling):- it means degree of dependency is less between two
 * object/class 
 */
/**
 * The Dependency Injection is a design pattern that removes the
 * dependency of the programs. In which ,values are assign to resource
 * at runtime		
 * 						<bean id="a" class="A" >
 * 						<property name="b" ref="b" />
 * 						</bean>
 */
/**
 * The IoC container is responsible to instantiate, configure and
 * initialize  the objects. The IoC container gets informations from the
 * XML file and works accordingly.
 *  
 * The main tasks performed by IoC container are:
 * 
 * 1)to instantiate the class
 * 2)to configure the object
 * 3)to assemble the dependencies between the objects
 * 
 * Types of IOC container :-
 * 1)BeanFactory  (interface)
 *				 implemented class XmlBeanFatory
 * 
 * 2)ApplicationContext (sub-interface)
 * 		implemented class 
 * 					1)classPathXmlApplicationContext :- its used when Xml file in Same location
 * 					2)FileSystemXmlApplocationContext:- its used when our Xml file is on different location 
 * 					3)XmlWebApplicationContext:-      its used by container internally in MVC  
 * 					4)AnnotationXmlApplication :- its used when we are using Annotation instead of XML (i think so)
 *  
 * 
 * Types of Dependency :
 * 		1)Primitive type:- like:- int a;
 * 
 * 	 	2)refrence type:-  like:- B b;       
 * 
 *		 3)Collection type:- like:- List list;
 *
 *		 4)String type:- like:- <bean id="view" class="......InternalViewResolver">
 *								<property name="suffix" value="/view" />
 *								<property name="prefix" value=".jsp" />
 *								</bean>
 *
 *Types Of Dependency Injection :-
 *		1)Setter injection:-(here first create the object and then assign the value) 
 *							in setter injection in which ,if dependency injection as setter type then container first create the 
 *							object of caller lass and then create the object of bean class 
 *
 *		2)Constructor Injection:-(here values is assign at the time of object creation)
 *							and in which ,container first creates the object of  dependency bean class  and then caller class object
 *		
 *		3)lookup method injection:-
 *
 * 
 * Scopes:-
 * there are five types of object 
 * 1) Singleton :- if we declare class scope as singleton then for every request it return same object 
 * 				<bean id="b" class="B" scope="Singleton" />
 * 
 *  2)Prototype :-if we declare class scope as prototype then for every request it return new Object 
 *  			
 *  3)request :- its scope used in SpringMVC , in which for every request One object is created
 *  
 *  4)Session :- its also used in Spring-MVC module , in which object is create for every session
 *  
 *  5)globaleSession :- here object is create for entire Application 
 *  
 *  
 *  Autowiring :-Means (Container automatically detect the dependency and injecting them into caller class)
 *  	
 *  	if use Autowire attribute in xml like <bean id="a" class="A" Autowired="ByName" />
 *      			then container check proerty name and bean class id in Xml if matched then detect the dependency and inject the values to target class or caller class
 *  
 *  there 5 types in Autowiring :-
 *  
 *  1)byName :- if we declare Autowiring as byName then it will match property name and id in XMl   //here we no need to use gettter method in bean class
 * 
 *  2)byType :- if we declare Autowiring as byType then it will match property type and class name in XMl
 * 
 *  3)Contructor :-its most same as ByType (but ....)
 * 
 *  4)no :-  here we are using <ref> tag in perform dependency injection operation
 *  
 *  5)Auto-detect :- here they are internally using constructor first if not possible with that and then byName use .. to detect the
 *  				 dependency and if found then perform injection operation to target class
 *  
 *  
 *  
 *  Circular Dependency Problem:-
 *  	Suppose ,
 *  			if we have two bean class A and B  where A depends on B && B depends on A  
 *  			and both beans define constructor injection   then circular dependency problem will occur 
 *  
 *  			class A{				class B {
 *  				B b;					A a;
 *  				A(B b){					B(A a){
 *  				}						}
 * 				}						}
 * Solution :-  to resolve the  this issue change the dependency type of one class is constructor to setter 
 * 						then internally container will do following things :-
 * 								1)creates a mock object of A 
 * 								2)injects mock object A to Class B through Constructor 
 * 								3) and inject the object of B to class A through setter  
 * 
 * 
 * Q)what is BeanPostProcessor?
 * 		in Spring Application ,if a multipal beans having common intialization logic and and if each bean define sepratly 
 * 			then duplication of code problum may occur in Appl.
 * 		
 * 		to avid duplication of intialization logic 
 * 							framework provide BeanPostProcessor interface.
 * 
 * 		here we are creating spreate class by implementing BeanPostProcessor interface to define common initalization logic 
 * 		like
 * 				public class myBeanPostProcessor implements BeanPostProcessor{
 * 				
 * 					@override
 * 					p Object postProcessBeforIntialization(Object bean, String name){
 * 					
 * 						////
 * 					}
 * 					@override
 * 					public Object postProcessAfterInitialization(Object bean ,String name){
 * 					
 * 						///
 * 					}
 * 				}
 * 
 *  		here container 1st call postProcessBeforIntialization() and after that initialization method defind the bean class 
 *  			and finally postProcessAfterInitialization will be called
 *  		
 *  		@override
 * 					p Object postProcessBeforIntialization(Object bean, String name){
 * 					
 * 						////
 * 					}
 * 
 * 					steUp();
 * 					
 * 					@override
 * 					public Object postProcessAfterInitialization(Object bean ,String name){
 * 					
 * 						///
 * 					}
 * 	
 * 		Q)Life cycle of Bean ?
 * 				5 stage in 	life cycle of Bean 
 * 					1)does not exisit :- befor an obj of bean-class created,its at does not exist stage
 * 	
 * 					2)instatiation:- here container creates object of bean(internally conatiner will call jvm to create obj)
 * 
 * 										1)after instantion of object conatiner will call to constructor to intialize object
 * 										constructor--> 
 * 										
 * 										2)after constructor is execute container will inject the dependencies
 * 										dependecies are injected-->
 * 
 * 										
 * 										3)after that container ckeck weather bean class implemnts BeanNameAware interface or not 
 * 												if yes then call below methods
 * 										setBanName()
 * 
 * 										4)after that container ckeck weather bean class implemnts ApplicationContextn or not if yes
 * 										then implement steApplicationContext()
 * 										setApplicationContext();
 * 										
 * 		
 * 										5)if we define custom intit() then internally call
 * 										postProcessBeforIntialization();
 * 										afterPropertiesSet()
 * 										customIntitMethod()
 * 										postProcessAfterInitialization()
 * 
 * 
 * 										
 * 										
 * 					3)initilized:-and here bean is intialized and ready to provide service 
 * 					4)service
 * 						
 * 					5)destory:-	befor destorying bean object container call finalize()
 * 									finalize()
 * 									custom destory Method
 * 									destory()	
 * 					
 * 				
 * 
 * 		 */
public class Test {
	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/spring/SpringConfig.xml");

		Student s = (Student) ac.getBean("student");
		s.Display();
	}

}
