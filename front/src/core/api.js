const basePath = process.env.REACT_APP_API_ENDPOINT;
const doFetch = (resourcePath) => {
  return fetch(basePath + resourcePath, {
    headers: {
      'Content-Type': 'application/json',
      'Authorization': 'Bearer ' + process.env.REACT_APP_ACCESS_TOKEN
    },
  })
}

export default {
  getTop5Followers: () => doFetch('/users/top-5-followers'),
  getTweetsGroupByTagLang: () => doFetch('/tweets/total-by-tag-lang'),
  getTweetsGroupByHour: () => doFetch('/tweets/total-by-hour')
}
