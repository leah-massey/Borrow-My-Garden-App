
const AddGardenForm = () => {
    return (
        <div className="flex  items-center justify-center h-screen mt-28">
        <section className="bg-white  p-10 rounded-lg shadow-lg w-2/5">
            <h2 className="font-bold text-2xl mb-4">Add a Garden</h2>
            <form>
                <div className="space-y-12">
                    <div className="border-b border-gray-900/10 pb-12">

                        <p className="flex text-sm mt-4">
                            Ready to List your garden? Fill in the form below to start attracting gardeners 👨🏽‍🌾
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
                                            // id="username"
                                            // name="username"
                                            type="text"
                                            // autoComplete="username"
                                            className="block flex-1 border-0 bg-transparent py-1.5 pl-1 text-gray-900 placeholder:text-gray-400 focus:ring-0 sm:text-sm sm:leading-6"
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
                    id="about"
                    name="about"
                    rows={4}
                    className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                    defaultValue={''}
                />
                                </div>

                            </div>


                        </div>
                    </div>

                    <div className="sm:col-span-4">
                        <label htmlFor="first-name" className="block font-bold mb-2">
                            First Name
                        </label>
                        <div className="mt-2">
                            <div
                                className="flex rounded-md shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-inset focus-within:ring-indigo-600 sm:max-w-md">
                                    <span
                                        className="flex select-none items-center pl-3 text-gray-500 sm:text-sm"></span>
                                <input
                                    // id="username"
                                    // name="username"
                                    type="text"
                                    // autoComplete="username"
                                    className="block flex-1 border-0 bg-transparent py-1.5 pl-1 text-gray-900 placeholder:text-gray-400 focus:ring-0 sm:text-sm sm:leading-6"
                                />
                            </div>
                        </div>
                    </div>

                    <div className="sm:col-span-4">
                        <label htmlFor="userId" className="block font-bold mb-2">
                            User Id
                        </label>
                        <div className="mt-2">
                            <div
                                className="flex rounded-md shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-inset focus-within:ring-indigo-600 sm:max-w-md">
                                    <span
                                        className="flex select-none items-center pl-3 text-gray-500 sm:text-sm"></span>
                                <input
                                    // id="username"
                                    // name="username"
                                    type="text"
                                    // autoComplete="username"
                                    className="block flex-1 border-0 bg-transparent py-1.5 pl-1 text-gray-900 placeholder:text-gray-400 focus:ring-0 sm:text-sm sm:leading-6"
                                />
                            </div>
                        </div>
                    </div>


                            <div className="sm:col-span-3">
                                <label htmlFor="country" className="block text-sm font-medium leading-6 text-gray-900">
                                    Garden Status
                                </label>
                                <div className="mt-2">
                                    <select
                                        id="country"
                                        name="country"
                                        autoComplete="country-name"
                                        className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:max-w-xs sm:text-sm sm:leading-6"
                                    >
                                        <option>AVAILABLE</option>
                                        <option>NOT_AVAILABLE</option>
                                    </select>
                                </div>
                            </div>



                </div>

                <div className="mt-6 flex items-center justify-center gap-x-6">
                    <button type="button" className="text-sm font-semibold leading-6 text-gray-900 bg-gray-400 rounded-md p-2 md-2">
                        Submit
                    </button>
                </div>
            </form>
        </section>
        </div>
    )
}
export default AddGardenForm
