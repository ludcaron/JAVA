import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class SubMailTest {

    @Mock
    private GroupRepository groupRepository;

    @InjectMocks
    private TestMailSub testMailSub;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetUserGroupSubbUserCount() {
        Integer userID = 1;
        List<Object[]> mockResult = Arrays.asList(
            new Object[]{1, "Group1", BigInteger.valueOf(10)},
            new Object[]{2, "Group2", BigInteger.valueOf(20)}
        );

        // Mock the behavior of the repository
        when(groupRepository.findGroupsMailSubsUsersCount(userID)).thenReturn(mockResult);

        // Call the method to test
        List<UserGroupsMailSubsDto> result = testMailSub.getUserGroupSubbUserCount(userID);

        // Verify that the repository method was called with the correct argument
        verify(groupRepository, times(1)).findGroupsMailSubsUsersCount(userID);

        // Additional assertions to verify the result
        assertEquals(2, result.size());

        assertEquals(1, result.get(0).getGroupID());
        assertEquals("Group1", result.get(0).getGroupName());
        assertEquals(BigInteger.valueOf(10), result.get(0).getMailSubsCount());

        assertEquals(2, result.get(1).getGroupID());
        assertEquals("Group2", result.get(1).getGroupName());
        assertEquals(BigInteger.valueOf(20), result.get(1).getMailSubsCount());
    }
}