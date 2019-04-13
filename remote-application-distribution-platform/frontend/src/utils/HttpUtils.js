const fetchFields = {
  mode: "cors", // no-cors, cors, *same-origin
  cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
  credentials: "same-origin", // include, *same-origin, omit
  redirect: "follow", // manual, *follow, error
  referrer: "no-referrer" // no-referrer, *client
};
export async function post(url, data) {
  // Default options are marked with *
  return fetch(url, {
    method: "POST",
    ...fetchFields,
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(data) // body data type must match "Content-Type" header
  }); // parses response to JSON
}
export async function get(url) {
  return fetch(url, {
    method: "GET",
    ...fetchFields,
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json"
    }
  });
}
