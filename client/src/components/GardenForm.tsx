import {useEffect, useState} from "react";
import {v4 as uuidv4} from 'uuid'


const GardenForm = ({data}) => {
    const [formData, setFormData] = useState(data)

    console.log(data)

    useEffect(() => {
        setFormData(data)
    }, [data]);

    const handleSubmit = (e) => {
        e.preventDefault()
        const formDataValue = new FormData(e.target)
        // console.log(formData)
        const gardenDataPayload = Object.fromEntries(formDataValue) as { [p: string]: string | File }
        const gardenId = uuidv4()
        const dateCreatedTimestamp = new Date().toISOString()

        const garden = {
            id: gardenId,
            title: gardenDataPayload.title,
            description: gardenDataPayload.description,
            gardenOwnerFirstName: gardenDataPayload.gardenOwnerFirstName,
            gardenStatus: gardenDataPayload.status,
            createdTimestamp: dateCreatedTimestamp,
            gardenOwnerId: gardenDataPayload.gardenOwnerId,
        }
        fetch('http://localhost:9000/internal/gardens', {
            method: 'POST',
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(garden)
        }).then(response => {
            if (!response.ok) {
                throw new Error('Failed to add garden');
            }
            console.log("your garden has been added :-)")
        }).catch(error => {
            console.error("There was an error with the fetch request:", error);
        })
    }


    return (
        <div className="flex  items-center justify-center h-screen mt-28">
            <section className="bg-white  p-10 rounded-lg shadow-lg w-2/5">
                <h2 className="font-bold text-2xl mb-4">{formData ? "Edit" : "Add"} a Garden</h2>
                <form onSubmit={handleSubmit}>
                    <div className="space-y-12">
                        <div className="border-b border-gray-900/10 pb-12">
                            <p className="flex text-sm mt-4">
                                Ready to List your garden? Fill in the form below to start attracting gardeners
                                👨🏽‍🌾
                            </p>
                            <div className="grid grid-cols-1 gap-x-6 gap-y-10 mt-10">
                                <div className="sm:col-span-4">
                                    <label htmlFor="title" className="block font-bold mb-2">
                                        Title
                                    </label>
                                    <div className="mt-2">
                                        <div
                                            className="flex rounded-md shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-inset focus-within:ring-indigo-600 sm:max-w-md">
                                    <span
                                        className="flex select-none items-center pl-3 text-gray-500 sm:text-sm"></span>
                                            <input
                                                value={formData ? formData.title : undefined}
                                                onChange={(e) => {
                                                    setFormData((state) => ({...state, title: e.target.value}))
                                                }}
                                                id="title"
                                                name="title"
                                                type="text"
                                                className="block flex-1 border-0 bg-transparent py-1.5 pl-1 text-gray-900 focus:ring-0 sm:text-sm sm:leading-6"
                                            />
                                        </div>
                                    </div>
                                </div>

                                <div className="col-span-full">
                                    <label htmlFor="description" className="block font-bold mb-2">
                                        Description
                                    </label>
                                    <div className="mt-2">
                                        <textarea
                                            // value={formData ? formData.description : undefined}
                                            id="description"
                                            name="description"
                                            rows={4}
                                            className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                                            defaultValue={''}
                                        />
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div className="sm:col-span-4">
                            <label htmlFor="garden-owner-first-name" className="block font-bold mb-2">
                                Your First Name
                            </label>
                            <div className="mt-2">
                                <div
                                    className="flex rounded-md shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-inset focus-within:ring-indigo-600 sm:max-w-md">
                                    <span
                                        className="flex select-none items-center pl-3 text-gray-500 sm:text-sm"></span>
                                    <input
                                        // onChange={(e) => {setGardenOwnerFirstName(e.target.value)}}
                                        id="garden-owner-first-name"
                                        name="gardenOwnerFirstName"
                                        type="text"
                                        className="block flex-1 border-0 bg-transparent py-1.5 pl-1 text-gray-900 focus:ring-0 sm:text-sm sm:leading-6"
                                    />
                                </div>
                            </div>
                        </div>

                        <div className="sm:col-span-4">
                            <label htmlFor="garden-owner-id" className="block font-bold mb-2">
                                Your User Id
                            </label>
                            <div className="mt-2">
                                <div
                                    className="flex rounded-md shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-inset focus-within:ring-indigo-600 sm:max-w-md">
                                    <span
                                        className="flex select-none items-center pl-3 text-gray-500 sm:text-sm"></span>
                                    <input
                                        // onChange={(e) => {setGardenOwnerId(e.target.value)}}
                                        id="garden-owner-id"
                                        name="gardenOwnerId"
                                        type="text"
                                        className="block flex-1 border-0 bg-transparent py-1.5 pl-1 text-gray-900 focus:ring-0 sm:text-sm sm:leading-6"
                                    />
                                </div>
                            </div>
                        </div>


                        <div className="sm:col-span-3">
                            <label htmlFor="status" className="block text-sm font-medium leading-6 text-gray-900">
                                Garden Status
                            </label>
                            <div className="mt-2">
                                <select
                                    id="status"
                                    name="status"
                                    className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:max-w-xs sm:text-sm sm:leading-6"
                                >
                                    <option>AVAILABLE</option>
                                    <option>NOT_AVAILABLE</option>
                                </select>
                            </div>
                        </div>


                    </div>

                    <div className="mt-6 flex items-center justify-center gap-x-6">
                        <button
                            // onClick={handleSubmit}
                            type="submit"
                            className="text-sm font-semibold leading-6 text-gray-900 bg-gray-400 rounded-md p-2 md-2">
                            Submit
                        </button>
                    </div>
                </form>
            </section>
        </div>
        // </>
    )
}
export default GardenForm
