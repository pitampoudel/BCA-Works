#include <stdio.h>
#include <windows.h>

void main()
{
    HANDLE hMapFile;
    char *pBuf;

    // Open the memory-mapped file
    hMapFile = OpenFileMapping(
        FILE_MAP_READ,   // Read access
        FALSE,           // Do not inherit the handle
        "SharedMemory"); // Name of the shared memory

    if (hMapFile == NULL)
    {
        printf("Child: Failed to open shared memory. Error: %ld\n", GetLastError());
        return;
    }

    // Map the view of the memory-mapped file
    pBuf = (char *)MapViewOfFile(hMapFile, FILE_MAP_READ, 0, 0, 256);
    if (pBuf == NULL)
    {
        printf("Child: Could not map view of file. Error: %ld\n", GetLastError());
        CloseHandle(hMapFile);
        return;
    }

    // Read from shared memory
    printf("Child received from Shared Memory: %s\n", pBuf);

    // Unmap the memory-mapped file and close handle
    UnmapViewOfFile(pBuf);
    CloseHandle(hMapFile);
}