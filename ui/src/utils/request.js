import responseHandler from './responseHandler';

export default function request(url, options) {
  return fetch(url, options)
    .then(responseHandler);
}

export function get(url, options = {}) {
  options.method = 'GET';
  return request(url, options);
}

export function post(url, options = {}) {
  options.method = 'POST';
  options.headers = Object.assign({
    'Content-Type': 'application/json'
  }, options.headers ? options.headers : {});

  return request(url, options);
}