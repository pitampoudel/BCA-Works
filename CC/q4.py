import base64
# Original data
data = "CloudSecurity2026"
# Encrypt
encoded = base64.b64encode(data.encode())
print("Encrypted Data:", encoded)
# Decrypt
decoded = base64.b64decode(encoded).decode()
print("Decrypted Data:", decoded)
