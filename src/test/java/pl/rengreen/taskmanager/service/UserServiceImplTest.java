package pl.rengreen.taskmanager.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.rengreen.taskmanager.model.User;
import pl.rengreen.taskmanager.repository.UserRepository;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userServiceMock;

    @Test
    public void findAll_shouldReturnUsersList() {
        List<User> expectedUsers = Arrays.asList(
                new User(),
                new User()
        );
        when(userRepository.findAll()).thenReturn(expectedUsers);

        assertThat(userServiceMock.findAll()).isEqualTo(expectedUsers);
    }
}