const { createServer } = require('http');
const next = require('next');

console.log(`Running on Node.js version: ${process.version}`);

// Port provided by Azure or default to 3000 for local development
const port = process.env.PORT || 3000;

// Check if the app is running in development mode
const dev = process.env.NODE_ENV !== 'production';

// Initialize the Next.js app
const app = next({ dev });
const handle = app.getRequestHandler();

// Prepare the Next.js app and start the server
app.prepare().then(() => {
  createServer((req, res) => {
    // Use Next.js to handle all requests
    handle(req, res);
  }).listen(port, (err) => {
    if (err) throw err;
    console.log(`> Ready on http://localhost:${port}`);
  });
});
