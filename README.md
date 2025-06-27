# Refrigerator inventory management - A sample Spring AI Server Client setup for demo of MCP server/client
The Refrigerator Inventory Management project uses the Model Context Protocol (MCP) framework, integrating an AI chatbot 
with a Spring Boot application. MCP clients connect to a server, which queries a local database (PostgreSQL), 
and receive answers from an AI model, providing inventory management functionality for refrigerators.

## How to set up
- Either run local PostgreSQL or spin docker or connects via NeonDB. Just ensure you have set up PostgreSQL.

- Now you are supposed to run ollama in local system (one can use api-key of any LLM model as well, but ollama set up is free) =>
```
Install Ollama for local set up.
Go to powershell and run command :
> ollama list
> ollama pull llama3.2:latest (if not installed, 2GB model will get get installed)
> ollama run llama3.2

Now run all three app (refrigerator-inventory-core, mcp-server, mcp-client).
```
## How to verify MCP server giving results from our own Database instead of global internet
```
Go to swagger for verification => http://localhost:8082/swagger-ui/index.html#/ai-chat-controller
say, click on 'Try it out', and type "what is the capital of India" at Request Body to verify llama3.2 connecting spring boot.
You'll get answer as "New Delhi"

To test project that is MCP able to answer from my db data => http://localhost:8082/swagger-ui/index.html#/mcp-chat-controller/chat
say, click on 'Try it out', and type "Product below 100 rupees" at Request Body to verify llama3.2 connecting spring boot.

And in Response Body you'll get something like (it'll vary structure of answer as generating via LLM everytime):

Here are some products available below 100 rupee:

1. Eggs - priced at 10.0 rupees
2. Cucumber - priced at 40.0 rupees
3. Spinach - priced at 19.99 rupees
4. Gulaab Jamun - priced at 99.0 rupees

```

![screenshot.png](https://raw.githubusercontent.com/AadityaUoHyd/refrigerator-inventory-mgmt/refs/heads/main/screenshot.png)

## Conclusion
Which tells mcp clients connects to mcp-server, which connects to refrigerator-inventory-core app and providing answer from our db.