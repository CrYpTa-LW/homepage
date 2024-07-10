import React, {useState} from "react";
import * as FaIcons from "react-icons/fa"
import * as AiIcons from "react-icons/ai"
import { Link } from "react-router-dom";
import {SidebarData} from "./SidebarData"
import "../App.css"
import {IconContext} from "react-icons"


function Sidebar() {

    const [sidebar, setSidebar] = useState(false);

    const showSidebar = () => setSidebar(!sidebar);

    return (
        <>
        <IconContext.Provider value={{color: "undefined"}}>
            <div className="sidebar">
                <Link to="#" className="menu-bars">
                    <FaIcons.FaBars onClick={showSidebar} />
                </Link>
            </div>
            <nav className={sidebar ? "side-menu active" : "side-menu"}>
                <ul className="side-menu-item" onClick={showSidebar}>
                    <li className="sidebar-toggle">
                        <Link to="#" className="menu-bars">
                            <AiIcons.AiOutlineClose />
                        </Link>
                    </li>
                    {SidebarData.map((item, index) => {
                        return (
                            <li key={index} className={item.cName}>
                                <Link to={item.path}>
                                    {item.icons}
                                    <span>{item.title}</span>
                                </Link>
                            </li>
                        )
                    })}
                </ul>
            </nav>
        </IconContext.Provider>
        </>
    )
}

export default Sidebar