# 🌐 Java Web Server (Single-Threaded & Multithreaded)

A **Java-based HTTP web server** showcasing three server models:
**Single-threaded**, **multi-threaded**, and **thread-pool based** implementations.
This project demonstrates practical understanding of **Java concurrency, networking, and performance trade-offs**.

---

## 🚀 Features

* Single-threaded server implementation
* Multi-threaded server (thread-per-request model)
* Thread pool–based server using `ExecutorService`
* Handles multiple client connections
* Basic HTTP request parsing
* Supports GET requests
* Clean separation of server and request-handling logic
* Lightweight and dependency-free

---

## 🛠 Tech Stack

* Java 17 (Java 8+ compatible)
* Java Sockets (`ServerSocket`, `Socket`)
* Java Threads
* `ExecutorService` & Thread Pools
* Java I/O Streams

---

## ⚙️ Server Models Implemented

### 1️⃣ Single-Threaded Server

* Processes one client request at a time
* Simple and easy to understand
* Blocks all incoming requests while processing

**Use case:** Learning basics of sockets & request handling

---

### 2️⃣ Multi-Threaded Server (Thread-per-Request)

* Creates a new thread for each client connection
* Supports concurrent request handling
* Can lead to high resource usage under heavy load

**Use case:** Moderate traffic, learning concurrency

---

### 3️⃣ Thread Pool–Based Server

* Uses a fixed-size thread pool via `ExecutorService`
* Reuses worker threads efficiently
* Prevents uncontrolled thread creation
* Best balance between performance and resource usage

**Use case:** Production-like server model

---

## 📂 Project Structure

```
src/
 ├── main/
 │    ├── java/
 │    │    ├── src/
 │    │    │    ├── SingleThreadedServer
 │    │    │    ├── MultiThreadedServer
 │    │    │    ├── ThreadPoolServer
```

---

## 🔄 Request Handling Flow

1. Server starts and listens on a port
2. Client sends HTTP request
3. Connection is accepted
4. Request is handled based on server model:

   * Single thread
   * New thread per request
   * Thread pool worker
5. HTTP response is returned
6. Connection is closed

---

## ▶️ Running the Server

### Single-Threaded

```bash
java SingleThreadedServer
```

### Multi-Threaded

```bash
java MultiThreadedServer
```

### Thread Pool

```bash
java ThreadPoolServer
```

Server runs at:

```
http://localhost:8080
```

---

## 🧪 Testing & Comparison

* Open multiple browser tabs
* Use `curl` or Apache Bench
* Observe performance differences between models
* Compare response times and throughput

---

## 📈 Future Enhancements

* Configurable thread pool size
* Request queue monitoring
* Support for POST requests
* Static file serving
* Graceful shutdown
* Performance benchmarking
