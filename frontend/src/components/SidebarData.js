import React from "react";
import * as FaIcons from "react-icons/fa"
import * as AiIcons from "react-icons/ai"
import * as IoIcons from "react-icons/io"

export const SidebarData = [
    {
        title: "Home",
        path: "/",
        icons: <AiIcons.AiFillHome/>,
        cName: "nav-text",
    },
    {
        title: "Playlist Stats",
        path: "/playlist-stats",
        icons: <IoIcons.IoIosPaper/>,
        cName: "nav-text",
    },
    {
        title: "SongChange",
        path: "/song-change",
        icons: <IoIcons.IoIosPaper/>,
        cName: "nav-text",
    }
]