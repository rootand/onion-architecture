//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.whitepappers.services.user.impl;

import alekseybykov.portfolio.whitepappers.entities.User;
import alekseybykov.portfolio.whitepappers.exceptions.EntityNotFoundException;
import alekseybykov.portfolio.whitepappers.registries.UserRegistry;
import alekseybykov.portfolio.whitepappers.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-09-24
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRegistry userRegistry;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public User findByLogin(String login) {
        return userRegistry.findByLogin(login).orElseThrow(EntityNotFoundException::new);
    }
}