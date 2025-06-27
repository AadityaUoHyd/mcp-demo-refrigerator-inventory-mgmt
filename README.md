# 🧊 MCP Demo: Refrigerator Inventory Management

A **demo project** showcasing integration between an AI chatbot and a Spring Boot application using the **Model Context Protocol (MCP)** framework. It provides **inventory management** functionality for refrigerators by answering queries through an AI model, backed by a **PostgreSQL** database.

---

## 🛠️ Tech Stack

* Java / Spring Boot
* MCP Server / Client
* PostgreSQL / NeonDB
* Ollama with `llama3.2` (local LLM)
* Swagger UI (for testing endpoints)

---

## 🚀 Project Setup

### 1. Set Up PostgreSQL

You can either:

* Run PostgreSQL locally
* Use Docker to spin up a PostgreSQL container
* Connect via a hosted DB service like **NeonDB**

Make sure your database is properly configured and running.

---

### 2. Set Up Local LLM with Ollama

Install and run **Ollama** for local LLM support:

```powershell
> ollama list
> ollama pull llama3.2:latest
> ollama run llama3.2
```

> 💡 `llama3.2` is around 2GB and runs locally for free—no API key required!

---

### 3. Run the Applications

Make sure you run **all three** components:

* `refrigerator-inventory-core`
* `mcp-server`
* `mcp-client`

Each should be correctly configured to communicate with the database and each other.

---

## ✅ Verifying MCP with Local Data

### 🔍 Step 1: Test AI Model is Running

Go to Swagger UI:

```
http://localhost:8082/swagger-ui/index.html#/ai-chat-controller
```

* Click **Try it out** on the `chat` endpoint
* Enter:

  ```json
  {
    "message": "What is the capital of India?"
  }
  ```
* You should see:

  ```
  New Delhi
  ```

> ✔️ Confirms the local `llama3.2` is up and integrated.

---

### 🔍 Step 2: Verify Response from Local Database

Navigate to:

```
http://localhost:8082/swagger-ui/index.html#/mcp-chat-controller/chat
```

* Click **Try it out** and enter:

  ```json
  {
    "message": "Product below 100 rupees"
  }
  ```

* Sample response:

  ```
  Here are some products available below 100 rupees:

  1. Eggs - priced at 10.0 rupees
  2. Cucumber - priced at 40.0 rupees
  3. Spinach - priced at 19.99 rupees
  4. Gulaab Jamun - priced at 99.0 rupees
  ```

> ✔️ This confirms that the MCP server retrieves and responds using **your own database**, not internet data.

---

## 📸 Screenshot

![Demo Screenshot](https://raw.githubusercontent.com/AadityaUoHyd/refrigerator-inventory-mgmt/refs/heads/main/screenshot.png)

---

## 🧾 Conclusion

The **MCP Client** connects to the **MCP Server**, which interacts with the `refrigerator-inventory-core` app and **provides AI-generated answers based on your local database**.

> 🎯 A practical demonstration of a local AI system working in real-time with your Spring Boot and PostgreSQL setup!

