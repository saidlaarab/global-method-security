package spring.security.globalmethodsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import spring.security.globalmethodsecurity.permissionevaluator.DocumentsPermissionEvaluator;


@EnableGlobalMethodSecurity(prePostEnabled = true)
public class GlobalMethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    @Autowired
    private DocumentsPermissionEvaluator docPermissionEvaluator;

    // make Spring aware of our custom persmission evaluator
    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        var expressionHandler = new DefaultMethodSecurityExpressionHandler();
        expressionHandler.setPermissionEvaluator(docPermissionEvaluator);
        return expressionHandler;
    }
}
