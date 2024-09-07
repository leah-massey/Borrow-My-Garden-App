import React from 'react'
import {Outlet} from "react-router-dom";

const Layout = () => {
    return (
        <>
        <div>This is will be the browser tab (Layout)</div>
        <Outlet />
        </>
    )
}

export default Layout
