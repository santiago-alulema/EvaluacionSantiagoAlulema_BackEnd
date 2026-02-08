package com.example.evaluacionsantiagoalulema.services;

import com.example.evaluacionsantiagoalulema.clients.ExternalUserClient;
import com.example.evaluacionsantiagoalulema.dtos.external.implementation_2.ExternalUserDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ExternalUserServiceTest {

    @Test
    void getExternalUsers_shouldReturnUsersFromClient() {
        ExternalUserClient client = mock(ExternalUserClient.class);

        ExternalUserDto u1 = new ExternalUserDto();
        u1.id = 1;
        u1.name = "Leanne Graham";

        when(client.fetchUsers()).thenReturn(List.of(u1));

        UserService service = new UserService(client);

        List<ExternalUserDto> result = service.getExternalUsers();

        assertEquals(1, result.size());
        assertEquals(1, result.get(0).id);
        verify(client, times(1)).fetchUsers();
    }
}