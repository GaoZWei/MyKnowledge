import {querySearch} from '../services/search'
export default {
  namespace: 'searchs',
  state: {
    searchList: []
  },
  reducers: {
    querySearchSuccess(state,{payload}) {
      state.searchList=payload;
      console.log(state.searchList)
      return {...state}
    },
  },
  effects: {
    * queryShare({payload}, {put, call}) {
      const result = yield call(querySearch,payload);
      if (result) {
        yield put({
          type: 'querySearchSuccess',
          payload: result.data
        });
      }
    },
  },
  subscriptions: {},
}
