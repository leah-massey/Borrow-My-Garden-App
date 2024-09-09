import React from 'react'
import {Link} from "react-router-dom";

const GardenList = (props) => {
    const gardens = props.gardens

    return (
        <div className="garden-list">
            {gardens.map(garden => (
                <div key = {garden.id}>
                    <Link to={`/gardens/${garden.id}`}>
                        <h3>
                            {garden.title}
                        </h3>
                    </Link>
                </div>
            ))}
        </div>
    )
}

export default GardenList