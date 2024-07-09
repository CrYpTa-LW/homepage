import * as React from "react";
import { createRoot } from "react-dom/client";
import {
  createBrowserRouter,
  RouterProvider,
  Route,
  Link,
  Outlet,
} from "react-router-dom";
import Products from "./routes/Products";
import Home from "./routes/Home";
import Reports from "./routes/Reports";
import Sidebar from "./components/Sidebar";
import SongChange from "./components/SongChange";

import 'bootstrap/dist/css/bootstrap.min.css';


const AppLayout = () => (
  <>
    <Sidebar />
    <Outlet />
  </>
);

const router = createBrowserRouter([
  {
    element: <AppLayout/>,
    children: [
      {
        path: "/",
        element: <Home/>,
      },
      {
        path: "products",
        element: <Products/>,
      },
      {
        path: "reports",
        element: <Reports/>,
      },
      {
        path: "song-change",
        element: <SongChange/>,
      },
    ]
  },
]);

createRoot(document.getElementById("root")).render(
  <RouterProvider router={router} />
);