# Kaiwa (会話) — Spring Boot + MongoDB + WebSocket

Discord-like chat rooms with database authentication.

## Run

1. Set your MongoDB Atlas URI in `src/main/resources/application.properties`:
   ```
   spring.data.mongodb.uri=mongodb+srv://<username>:<password>@<cluster-host>/<database>?retryWrites=true&w=majority&appName=Kaiwa
   ```
2. Build and run:
   ```bash
   mvn spring-boot:run
   ```
3. Register a user:
   ```bash
   curl -X POST http://localhost:8080/api/auth/register -H "Content-Type: application/json" -d '{"username":"test","password":"test123"}'
   ```
4. Visit `http://localhost:8080/login` to login, then open `http://localhost:8080/chat.html`.
5. Enter a room id (e.g., `sports`) and chat!

## Notes
- WebSocket endpoint: `/ws` (SockJS enabled)
- STOMP app prefix: `/app`
- Subscribe: `/topic/{roomId}`
- Send: `/app/chat/{roomId}`
- Messages are persisted in MongoDB `messages` collection.
