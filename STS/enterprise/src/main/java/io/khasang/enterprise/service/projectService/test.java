package io.khasang.enterprise.service.projectService;


import io.khasang.enterprise.service.projectService.basicProject.AbstractBasicProject;
import io.khasang.enterprise.service.projectService.basicProject.Blog;
import io.khasang.enterprise.service.projectService.orderDecorator.AudioVideoManager;
import io.khasang.enterprise.service.projectService.orderDecorator.OnlinePayments;

public class test {
    public static void main(String[] args) {
        AbstractBasicProject blog = new Blog();
        AbstractProject audio = new AudioVideoManager(blog);
        AbstractProject payment = new OnlinePayments(audio);

        System.out.println(blog.getDescription());
        System.out.println(blog.getPrice());
        System.out.println(blog.getStatus());

        System.out.println("--------------------");
        System.out.println(payment.getDescription());
        System.out.println(payment.getTitle());
        System.out.println(payment.getPrice());
        audio.setId(5);

        System.out.println("---------------------");
        blog.setStatus(Status.FINISHED);
        System.out.println(blog.getStatus());


    }
}
