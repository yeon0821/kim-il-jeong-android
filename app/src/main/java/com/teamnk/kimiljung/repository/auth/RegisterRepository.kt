package com.teamnk.kimiljung.repository.auth
import com.teamnk.kimiljung.data.RegisterApi
import com.teamnk.kimiljung.data.dto.DuplicateRequest
import com.teamnk.kimiljung.data.dto.VerifyCodeRequest
import com.teamnk.kimiljung.data.dto.VerifyRequest
// TODO refactor
class RegisterRepository(
    private val registerApi: RegisterApi
) {
    suspend fun verify(verifyRequest: VerifyRequest) =
        registerApi.verify(verifyRequest)

    suspend fun verifyCode(verifyCodeRequest: VerifyCodeRequest) =
        registerApi.verifyCode(verifyCodeRequest)

    suspend fun idDuplicate(duplicateRequest: DuplicateRequest) =
        registerApi.idDuplicate(duplicateRequest)
}
