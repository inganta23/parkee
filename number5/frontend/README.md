# Parking Management System - Frontend

This is the frontend application for the Parking Management System, built using **React, Vite, Tailwind CSS, and Shadcn/ui**.

## Features

- **Check-In Page**: Allows users to check in by entering a plate number and receiving a parking ticket.
- **Check-Out Page**: Retrieves a ticket, displays the check-in and check-out time, and calculates the total price.
- **Printing**: Users can print parking tickets using `react-to-print`.
- **Responsive UI**: Fully responsive navigation bar for easy access to check-in and check-out pages.

## Tech Stack

- **React** (with TypeScript)
- **Vite** (for fast development)
- **Tailwind CSS** (for styling)
- **Shadcn/ui** (for UI components)
- **Axios** (for API requests)
- **React-to-Print** (for printing tickets)

## Installation

### Prerequisites

Ensure you have the following installed:

- **Node.js** (>= 16.0)
- **pnpm** (recommended)

### Setup

1. Clone the repository:

   ```sh
   git clone https://github.com/inganta23/parkee.git
   cd parking-app-frontend
   ```

2. Install dependencies:

   ```sh
   pnpm install  # or npm install
   ```

3. Start the development server:
   ```sh
   pnpm dev  # or npm run dev
   ```

## API Endpoints

The frontend communicates with a backend running at `http://localhost:8080` (api.ts).

## Printing Functionality

The `react-to-print` library is used to print parking tickets. Only the ticket card will be printed, not the entire page.

## Notifications

- **Sonner** from shadcn/ui is used to display success and error messages.
- Example:
  ```tsx
  import { toast } from "sonner";
  toast.success("Check-in successful!");
  ```

## Running in Production

To build for production:

```sh
pnpm build  # or npm run build
```
