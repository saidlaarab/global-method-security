package spring.security.globalmethodsecurity.permissionevaluator;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import spring.security.globalmethodsecurity.model.Document;
import java.io.Serializable;


@Component
public class DocumentsPermissionEvaluator implements PermissionEvaluator {
    @Override
    public boolean hasPermission(Authentication authentication, Object targetObject, Object permission) {
        Document document = (Document) targetObject;
        String requiredAuthority = permission.toString();

        // authenticated user's details:
        String username = authentication.getName();
        boolean userAuthorized = authentication.getAuthorities()
                .stream().anyMatch(authority -> authority.getAuthority().equals(requiredAuthority));

        // grand permission if the user is either admin or the document's owner.
        if(userAuthorized || document.getOwner().equals(username)){
            return true;
        }

        return false;

    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}
