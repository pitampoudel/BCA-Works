#include <stdio.h>
#include <windows.h>

int main() {
    STARTUPINFO si = { sizeof(si) };
    PROCESS_INFORMATION pi;

    // Create a new process (e.g., Notepad)
    if (CreateProcess(NULL, "C:\\Windows\\System32\\notepad.exe", NULL, NULL, FALSE, 0, NULL, NULL, &si, &pi)) {
        printf("Child process created successfully!\n");
        printf("Child Process ID: %lu\n", pi.dwProcessId);

        // Wait for the child process to terminate
        WaitForSingleObject(pi.hProcess, INFINITE);
        printf("Child process terminated.\n");

        // Clean up handles
        CloseHandle(pi.hProcess);
        CloseHandle(pi.hThread);
    } else {
        printf("Failed to create process. Error: %lu\n", GetLastError());
    }

    printf("Parent process exiting.\n");

    // Copyright
    printf("\n© 2025 Pitam. All rights reserved.\n");

    return 0;
}

