export default function responseHandler(response) {
  return new Promise((resolve, reject) => {
    if (response.status >= 500) {
      reject(new Error(response));
    } else {
      const contentType = response.headers.get('Content-Type');
      let bodyParser = response.text.bind(response);
      if (contentType) {
        if (contentType.includes('application/json')) {
          bodyParser = response.json.bind(response);
        }
      }

      bodyParser().then((body) => {
        if (response.ok) {
          resolve(body);
        } else {
          // TODO: fix better error handling
          reject(new Error('Failed to parse response body'));
        }
      });
    }
  });
}