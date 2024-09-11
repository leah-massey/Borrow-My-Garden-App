import React from 'react'
import {Link, Outlet} from "react-router-dom";

const Layout = () => {
    return (
        <>
            <ul className='horizontal-list'>
                <li><Link to='/add-garden'>Add a garden</Link></li>
                <li><p>This is will be the browser tab (Layout)</p></li>
            </ul>
        <Outlet />
        </>
    )
}

export default Layout
