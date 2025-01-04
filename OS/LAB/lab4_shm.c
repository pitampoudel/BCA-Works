#include <stdio.h>
#include <windows.h>

int main() {
    HANDLE hMapFile;
    char *pBuf;
    char writeMsg[] = "Hello from Parent!";
    
    // Create a memory-mapped file
    hMapFile = CreateFileMapping(
        INVALID_HANDLE_VALUE,    // Use paging file
        NULL,                    // Default security
        PAGE_READWRITE,          // Read/Write access
        0,                       // Maximum object size (high-order DWORD)
        256,                     // Maximum object size (low-order DWORD)
        "SharedMemory");         // Name of the map object

    if (hMapFile == NULL) {
        printf("Could not create file mapping object. Error: %ld\n", GetLastError());
        return 1;
    }

    // Map the view of the memory-mapped file into the process's address space
    pBuf = (char *)MapViewOfFile(hMapFile, FILE_MAP_ALL_ACCESS, 0, 0, 256);
    if (pBuf == NULL) {
        printf("Could not map view of file. Error: %ld\n", GetLastError());
        CloseHandle(hMapFile);
        return 1;
    }

    // Create a child process using CreateProcess
    STARTUPINFO si = { sizeof(si) };
    PROCESS_INFORMATION pi;
    BOOL processCreated = CreateProcess(
        NULL, "lab4_shm_child_process.exe",  // Replace with actual child program
        NULL, NULL, TRUE, 0, NULL, NULL, &si, &pi);

    if (processCreated) {
        // Parent process writes to shared memory
        memcpy(pBuf, writeMsg, strlen(writeMsg) + 1);
        printf("Parent wrote to Shared Memory: %s\n", writeMsg);

        // Wait for child process to finish
        WaitForSingleObject(pi.hProcess, INFINITE);
        CloseHandle(pi.hProcess);
        CloseHandle(pi.hThread);
    } else {
        // Child process reads from shared memory
        printf("Child read from Shared Memory: %s\n", pBuf);
    }

    // Unmap the memory-mapped file
    UnmapViewOfFile(pBuf);
    CloseHandle(hMapFile);

    // Copyright
    printf("\n© 2025 Pitam. All rights reserved.\n");

    return 0;
}

