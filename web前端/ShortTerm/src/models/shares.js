import {queryShare,deleteShare} from '../services/share'

export default {
  namespace: 'shares',
  state: {
    list: []
  },
  reducers: {
    queryShareSuccess(state, {payload}) {
      state.list = payload
      return {...state}
    },
  },
  effects: {
    * queryShare(payload, {put, call}) {
      const result = yield call(queryShare);
      if (result) {
        yield put({
          type: 'queryShareSuccess',
          payload: result.data
        });
      }
    },
    * deleteShare({payload}, {put, call}) {
      console.log(payload)
      //调用删除service
      yield call(deleteShare,payload)
      yield put({
        type: 'queryShare',
      });
    },
  },
  subscriptions: {
    setup({dispatch, history}) {
      history.listen(location => {
        if (location.pathname === '/share') {
          dispatch({
            type: 'queryShare',
            //payload: {}
          });
        }
      });
    },
  },
}
