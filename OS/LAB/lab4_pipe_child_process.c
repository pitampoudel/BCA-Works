#include <stdio.h>
#include <windows.h>

void main()
{
    HANDLE hPipe;
    char readMsg[100];
    DWORD bytesRead;

    // Open the named pipe
    hPipe = CreateFile(
        "\\\\.\\pipe\\MyPipe", // Pipe name
        GENERIC_READ,          // Read access
        0,                     // No sharing
        NULL,                  // Default security attributes
        OPEN_EXISTING,         // Open existing pipe
        0,                     // Default attributes
        NULL);                 // No template

    if (hPipe == INVALID_HANDLE_VALUE)
    {
        printf("Child: Failed to open pipe. Error: %ld\n", GetLastError());
        return;
    }

    // Read from the pipe
    if (ReadFile(hPipe, readMsg, sizeof(readMsg) - 1, &bytesRead, NULL))
    {
        readMsg[bytesRead] = '\0'; // Null-terminate the string
        printf("Child received: %s\n", readMsg);
    }

    // Close the pipe
    CloseHandle(hPipe);
}